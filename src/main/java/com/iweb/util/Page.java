package com.iweb.util;

public class Page {
    int start;//开始位置
    int count;//每页显示多少条
    int total;//总数据量
    String param;//参数 暂时不用
    // 判断是否有上一页


    public Page(int start, int count) {
        this.start = start;
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public boolean isHasPreviouse(){
        if(start==0){
            return false;
        }
        return true;
    }
    //判断是否有下一页
    public boolean isHasNext(){
//        判断是否有下一页 想获取最后一页的下一页 必须先知道 最后一页的起始行在哪
        if(start==getLast()){
            return false;
        }
        return true;
    }

    //用于获取总页数
    // 如果你在JSP页面中使用的EL表达式中有实体类对象
    // ${page.totalpage}
    //等价于page.getTotalPage();
    public int getTotalPage(){
        int totalpage;
        //假设一共50条数据 每页五行 一共就10行
        if(total % count ==0){
            totalpage = total/count;
        }else{
            // 假设52条数据 每页五行 一共就11行
            totalpage = total / count + 1;
        }
        if(totalpage==0){
            totalpage=1;
        }
        return totalpage;
    }

    //获取数据分页之后 最后一页的行数
    public int getLast(){
        int last;
        //假设 数据一共有50条 每一页有五行数据 最后一页的开始 就是 45行
        if(total % count == 0 ){
            last = total - count;
        }else{
            //假设数据共有53条 不能被5整除 最后一页的开始 就是50行
            last = total - total % count;
        }
        //为了防止页数出现负数情况 需要对负数做处理
        last = last<0?0:last;
        return last;
    }


}
