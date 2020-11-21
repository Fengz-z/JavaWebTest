package com.sirifeng.mytag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author SiriFeng
 */
public class MathTag extends SimpleTagSupport {

    double x;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void doTag() throws IOException {
        JspWriter out = getJspContext().getOut();
        out.println(x+"的平方根是："+Math.sqrt(x));
    }

}
