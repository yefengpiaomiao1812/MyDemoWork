package com.example.cg.pattern.Command.example;

/**
 * 请求者 命令由按钮发起
 */
public class Buttons {

    private LeftCommand leftCommand;// 向左移动的命令对象引用
    private RightCommand rightCommand;// 像右移动的命令对象引用
    private FallCommand fallCommand;// 快速落下的命令对象引用
    private TransformCommand transformCommand;// 变换形状的命令对象的引用

    public void setLeftCommand(LeftCommand leftCommand) {
        this.leftCommand = leftCommand;
    }

    public void setRightCommand(RightCommand rightCommand) {
        this.rightCommand = rightCommand;
    }

    public void setFallCommand(FallCommand fallCommand) {
        this.fallCommand = fallCommand;
    }

    public void setTransformCommand(TransformCommand transformCommand) {
        this.transformCommand = transformCommand;
    }


    /**
     * 按下按钮向左移动
     */
    public void toLeft(){
        this.leftCommand.execute();
    }

    /**
     * 按下按钮向右移动
     */
    public void toRight(){
        this.rightCommand.execute();
    }

    /**
     * 按下按钮快速落下
     */
    public void fall(){
        this.fallCommand.execute();
    }

    /**
     * 按下按钮改变形状
     */
    public void transform(){
        this.transformCommand.execute();
    }

}
