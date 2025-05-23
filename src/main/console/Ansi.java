package main.console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Ansi {
    public static final String RESET = "\u001B[0m";

    public static final String BOLD = "\u001B[1m";
    public static final String NORMAL = "\u001B[2m";
    public static final String ITALIC = "\u001B[3m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String BLINK = "\u001B[5m";
    public static final String RAPID_BLINK = "\u001B[6m";
    public static final String REVERSE_VIDEO = "\u001B[7m";
    public static final String INVISIBLE_TEXT = "\u001B[8m";

    public static final String BLACK = "\u001B[30m";
    public static final String GREY = "\u001B[1;30m";
    public static final String DARK_RED = "\u001B[31m";
    public static final String RED = "\u001B[1;31m";
    public static final String DARK_GREEN = "\u001B[32m";
    public static final String GREEN = "\u001B[1;32m";
    public static final String DARK_YELLOW = "\u001B[33m";
    public static final String YELLOW = "\u001B[1;33m";
    public static final String DARK_BLUE = "\u001B[34m";
    public static final String BLUE = "\u001B[1;34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String MAGENTA = "\u001B[1;35m";
    public static final String DARK_CYAN = "\u001B[36m";
    public static final String CYAN = "\u001B[1;36m";
    public static final String SMOKE = "\u001B[37m";
    public static final String WHITE = "\u001B[1;37m";

    public static final String	BACKGROUND_BLACK	= "\u001B[40m";
    public static final String	BACKGROUND_RED		= "\u001B[41m";
    public static final String	BACKGROUND_GREEN	= "\u001B[42m";
    public static final String	BACKGROUND_YELLOW	= "\u001B[43m";
    public static final String	BACKGROUND_BLUE		= "\u001B[44m";
    public static final String	BACKGROUND_MAGENTA	= "\u001B[45m";
    public static final String	BACKGROUND_CYAN		= "\u001B[46m";
    public static final String	BACKGROUND_WHITE	= "\u001B[47m";
}
