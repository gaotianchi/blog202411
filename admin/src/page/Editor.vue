<template>
	<div>
		<div class="IH4loQPH">
			<div class="cxDvLOjg">
				<button class="q3wfQuVl" type="button">发布</button>
				<button class="q3wfQuVl" type="button">取消发布</button>
				<button class="q3wfQuVl" type="button">删除</button>
				<button class="q3wfQuVl" type="button">更新</button>
			</div>
		</div>
		<div>
			<div>
				<textarea
					type="text"
					class="NEMTSXIn"
					name="article-title"
					id="article-title"
					rows="1"
					@v-model="localTitle"
					placeholder="文章标题"
					aria-label="文章标题"
				></textarea>
			</div>
			<div v-if="bodyEditor">
				<!-- 段首工具栏 -->
				<FloatingMenu
					:editor="bodyEditor"
					:tippy-options="{ duration: 100, placement: 'auto-end' }"
					class="cEoF1vIw"
				>
					<div class="">
						<button type="button" @click="setHeading(2)" class="UTMhN5fU">H2</button>
						<button
							type="button"
							@click="bodyEditor.chain().focus().toggleBold().run()"
							class="UTMhN5fU"
						>
							B
						</button>
						<button type="button" @click="toggleLinkNode" class="UTMhN5fU">Link</button>
					</div>
				</FloatingMenu>
				<!-- 常规选中文本工具栏 -->
				<BubbleMenu
					plugin-key="global"
					:editor="bodyEditor"
					:tippy-options="{ duration: 100 }"
					:should-show="
						p => {
							return p.to - p.from > 0 && !p.editor.isActive('illustration');
						}
					"
				>
					<div class="">
						<button
							type="button"
							@click="bodyEditor.chain().focus().toggleBold().run()"
							class="UTMhN5fU"
						>
							B
						</button>
						<button type="button" @click="toggleLinkNode" class="UTMhN5fU">Link</button>
					</div>
				</BubbleMenu>
				<!-- link 编辑面板 -->
				<BubbleMenu
					plugin-key="linkEditorPanel"
					:editor="bodyEditor"
					:tippy-options="{ duration: 100 }"
					:should-show="
						p => {
							const linkNode = p.editor.getAttributes('link');
							link.href = linkNode.href;
							link.openInNewTab = linkNode.target === '_blank' ? true : false;
							return p.editor.isActive('link');
						}
					"
				>
					<div class="GZTV3nty">
						<div class="">
							<input
								type="text"
								class="d030y5C00"
								name="link-editor"
								id="link-editor"
								placeholder="编辑链接"
								aria-label="编辑链接"
							/>
						</div>
						<div class="">
							<div class="" style="display: inline-block">
								<label for="new-tab">新标签</label>
								<input type="checkbox" name="new-tab" id="new-tab" />
							</div>
							<div class="" style="display: inline-block">
								<button type="button">取消</button>
							</div>
						</div>
					</div>
				</BubbleMenu>
				<EditorContent :editor="bodyEditor" />
			</div>
		</div>
	</div>
</template>
<script setup lang="ts">
	import { Editor, EditorContent } from '@tiptap/vue-3';
	import { onMounted, reactive, ref } from 'vue';
	import StarterKit from '@tiptap/starter-kit';
	import Placeholder from '@tiptap/extension-placeholder';
	import { FloatingMenu, BubbleMenu } from '@tiptap/vue-3';
	import Link from '@tiptap/extension-link';

	const bodyEditor = ref<Editor>();
	const localBody = ref('');
	const localTitle = ref('');
	onMounted(() => {
		initBodyEditor();
	});
	const initBodyEditor = () => {
		bodyEditor.value = new Editor({
			extensions: [
				StarterKit,
				Placeholder.configure({
					placeholder: '正文...',
				}),
				Link.configure({
					openOnClick: false,
					defaultProtocol: 'https',
				}),
			],
			content: '',
		});
		bodyEditor.value?.on('update', updateHtml);
		localBody.value = bodyEditor.value.getHTML();
	};
	const updateHtml = () => {
		if (bodyEditor.value) {
			localBody.value = bodyEditor.value?.getHTML();
		}
	};
	const setHeading = (level: number) => {
		if (bodyEditor.value) {
			bodyEditor.value
				.chain()
				.focus()
				.toggleHeading({ level: level as 2 | 3 | 4 | 4 })
				.run();
		}
	};
	// Link
	const link = reactive({
		href: '',
		openInNewTab: false,
	});
	const toggleLinkNode = () => {
		if (bodyEditor.value) {
			if (bodyEditor.value?.isActive('link')) {
				bodyEditor.value.chain().focus().extendMarkRange('link').unsetLink().run();
			} else {
				bodyEditor.value
					.chain()
					.focus()
					.extendMarkRange('link')
					.toggleLink({ href: '#' })
					.run();
			}
		}
	};
	const updateLink = () => {
		const target = link.openInNewTab ? '_blank' : '_self';
		bodyEditor.value
			?.chain()
			.extendMarkRange('link')
			.unsetLink()
			.setLink({ href: link.href, target: target })
			.run();
	};
	const unsetLink = () => {
		if (bodyEditor.value) {
			bodyEditor.value.chain().focus().extendMarkRange('link').unsetLink().run();
		}
	};
</script>
<style lang="css" scoped>
	#article-title {
		width: 100%;
		border: none;
		font-size: 2rem;
		font-weight: bolder;
	}
	#article-title:focus {
		outline: none;
	}
	.q3wfQuVl {
		margin-left: 15px;
	}
	.IH4loQPH {
		display: flex;
		justify-content: flex-end;
	}
	.GZTV3nty {
		background-color: white;
		border: 1 solid black;
	}
	.d030y5C00 {
		width: 100%;
	}
</style>
