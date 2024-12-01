package com.gaotianchi.auth.startup.task.impl;

import com.gaotianchi.auth.startup.task.StartupTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author gaotianchi
 * @since 2024/12/1 10:52
 **/
@Component
@Slf4j
public class DataInitializationTask implements StartupTask {
    @Override
    public void execute() throws Exception {
        log.info("DataInitializationTask start");
    }
}
