package com.example.cg.pattern.Command.example;

/**
 * 具体命令者 向左移动的命令
 */
public class LeftCommand implements Command {

    // 持有一个接收者对象的引用
    private TetrisMachine tetrisMachine;

    LeftCommand(TetrisMachine tetrisMachine) {
        this.tetrisMachine = tetrisMachine;
    }

    @Override
    public void execute() {
        // 调用游戏机的具体方法执行操作
        tetrisMachine.toLeft();
    }
}
