package com.sirifeng.mytag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;
import java.time.LocalDate;

/**
 * @author SiriFeng
 */
public class HelloTag implements SimpleTag {

    JspContext jspContext;
    JspTag parent;

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("ִ 执行 doTag()方法");
        jspContext.getOut().println("这是我的第一个标签。<br>");
        jspContext.getOut().println("现在的时间是："+ LocalDate.now()+"<br>");
    }

    @Override
    public void setParent(JspTag parent) {

        this.parent=parent;
    }
    @Override
    public JspTag getParent() {
        
        return parent;
    }

    @Override
    public void setJspContext(JspContext jspContext) {

        this.jspContext = jspContext;
    }
    @Override
    public void setJspBody(JspFragment jspFragment) {

    }
}
