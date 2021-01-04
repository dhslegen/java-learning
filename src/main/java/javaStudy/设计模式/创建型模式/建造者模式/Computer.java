package javaStudy.设计模式.创建型模式.建造者模式;

/**
 * 计算机类
 *
 * @author dhslegen
 */
public class Computer {
    /**
     * 必须
     */
    private String cpu;

    /**
     * 必须
     */
    private String ram;

    /**
     * 可选
     */
    private int usbCount;

    /**
     * 可选
     */
    private String keyboard;

    /**
     * 可选
     */
    private String display;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.usbCount = builder.usbCount;
        this.keyboard = builder.keyboard;
        this.display = builder.display;
    }

    public static class Builder {
        /**
         * 必须
         */
        private String cpu;

        /**
         * 必须
         */
        private String ram;

        /**
         * 可选
         */
        private int usbCount;

        /**
         * 可选
         */
        private String keyboard;

        /**
         * 可选
         */
        private String display;

        public Builder(String cup, String ram) {
            this.cpu = cup;
            this.ram = ram;
        }

        public Builder setUsbCount(int usbCount) {
            this.usbCount = usbCount;
            return this;
        }

        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder setDisplay(String display) {
            this.display = display;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
