package org.madmeg;

import org.madmeg.api.obfuscator.Loader;
import org.madmeg.api.plugin.Plugin;
import org.madmeg.impl.Core;

/**
 *
 * @author 0x0001
 * @author Madmegsox1
 * @since 23/12/2021
 * @version 1.0.0
 */

public class Main implements Plugin {
    @Override
    public void init() {
        System.out.println("init");
    }

    @Override
    public void onLoad() {
        System.out.println("onLoad");
    }

    @Override
    public void onConfig() {
        System.out.println("onConfig");
    }

    @Override
    public void onPoolTasks() { // Loads before all Tasks


    }

    @Override
    public void onExecute() { // Loads before execution of tasks and after pooling the tasks
        Core.TASK_FACTORY.queueTask(() -> {
            Core.LOGGER.printSuccess("Adding watermark");
            String line =  "#Obfuscated By 0x0001\n" + Loader.FILE.lines.get(0);
            Loader.FILE.lines.remove(0);
            Loader.FILE.lines.add(0, line);
            Core.LOGGER.printSuccess("Added watermark");
        });
    }
}
