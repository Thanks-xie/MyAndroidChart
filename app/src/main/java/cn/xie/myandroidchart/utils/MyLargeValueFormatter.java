package cn.xie.myandroidchart.utils;

import com.github.mikephil.charting.formatter.LargeValueFormatter;

import java.text.DecimalFormat;

/**
 * @author xiejinbo
 * @date 2019/11/4 0004 13:27
 */
public class MyLargeValueFormatter extends LargeValueFormatter {
    private static String[] SUFFIX = new String[]{
            "元", "万元"
    };
    private static final int MAX_LENGTH = 10;
    private DecimalFormat mFormat;
    private String mText = "";

    public MyLargeValueFormatter() {
        mFormat = new DecimalFormat("####E0");
    }

    @Override
    public String getFormattedValue(float value) {
        return makePretty(value) + mText;
    }

    /**
     * Creates a formatter that appends a specified text to the result string
     *
     * @param appendix a text that will be appended
     */
    public MyLargeValueFormatter(String appendix) {
        this();
        mText = appendix;
    }

    /**
     * Set an appendix text to be added at the end of the formatted value.
     *
     * @param appendix
     */
    @Override
    public void setAppendix(String appendix) {
        this.mText = appendix;
    }

    /**
     * Set custom suffix to be appended after the values.
     * Default suffix: ["", "k", "m", "b", "t"]
     *
     * @param suff new suffix
     */
    @Override
    public void setSuffix(String[] suff) {
        if (suff.length == 3) {
            SUFFIX = suff;
        }
    }

    /**
     * Formats each number properly. Special thanks to Roman Gromov
     * (https://github.com/romangromov) for this piece of code.
     */
    private String makePretty(double number) {

        String r = mFormat.format(number);
        r = r.replaceAll("E[0-9]",
                SUFFIX[Character.getNumericValue(r.charAt(r.length() - 1)) / 4]);

        while (r.length() > MAX_LENGTH || r.matches("[0-9]+\\.[a-z]")) {
            r = r.substring(0, r.length() - 2) + r.substring(r.length() - 1);
        }

        return r;
    }
}
