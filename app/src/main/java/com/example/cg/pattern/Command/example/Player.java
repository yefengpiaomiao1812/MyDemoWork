package com.example.cg.pattern.Command.example;

/**
 * 客户类  游戏玩家
 */
public class Player {

    public static void main(String[] args) {
        // 首先要有俄罗斯方块游戏
        TetrisMachine tetrisMachine = new TetrisMachine();
        // 根据游戏构造四种命令
        LeftCommand leftCommand = new LeftCommand(tetrisMachine);
        RightCommand rightCommand = new RightCommand(tetrisMachine);
        FallCommand fallCommand = new FallCommand(tetrisMachine);
        TransformCommand transformCommand = new TransformCommand(tetrisMachine);
        // 按钮可以执行不同命令
        Buttons buttons = new Buttons();
        buttons.setLeftCommand(leftCommand);
        buttons.setRightCommand(rightCommand);
        buttons.setFallCommand(fallCommand);
        buttons.setTransformCommand(transformCommand);

        // 操作按钮
        buttons.toLeft();
        buttons.toRight();
        buttons.fall();
        buttons.transform();
    }
}
