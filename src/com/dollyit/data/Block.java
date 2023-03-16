package com.dollyit.data;

public class Block {

    private static final char DEFAULT_CONTENT = '.';
    private static final boolean DEFAULT_FALLS_WITH_GRAVITY = false;
    private static final boolean DEFAULT_FALLS_THROUGH = true;

    private final char content;
    private final boolean fallsWithGravity;
    private final boolean fallsThrough;

    /**
     *  Default constructor, set all settings with defaults
     */
    public Block() {
        this.content = DEFAULT_CONTENT;
        this.fallsWithGravity = DEFAULT_FALLS_WITH_GRAVITY;
        this.fallsThrough = DEFAULT_FALLS_THROUGH;
    }

    /**
     * @param content value to set as content
     */
    public Block(char content) {
        this.content = content;
        this.fallsWithGravity = !DEFAULT_FALLS_WITH_GRAVITY;
        this.fallsThrough = !DEFAULT_FALLS_THROUGH;
    }

    /**
     * @return the block content
     */
    public char display() {
        return content;
    }

    /**
     * @return fallsWithGravity value
     */
    public boolean isFallsWithGravity() {
        return fallsWithGravity;
    }

    /**
     * @return fallsThrough value
     */
    public boolean isFallsThrough() {
        return fallsThrough;
    }
}
