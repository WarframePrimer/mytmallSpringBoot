package com.warframe.tmall.domain;


import lombok.Data;

/**
 * Created by warframe on 2017/6/8.
 * 分页类，存储分页的相关信息
 * <p>
 *页数和每页记录数，对应mysql数据库中的记录就是(pageNum-1)*count,count
 * for example pageNum=3,count=6 那么对应数据库中应该从(3-1)*6开始，也就是记录的第13条(mysql中记录是从0开始的)
 * 使用泛型
 */
@Data
public class Page<T> {
    private int totalRecords;//总记录数
    private int count;//每页的记录数
    private int pageNum;//当前页数

    /**
     * 新增，当前要查询目标在数据库中的位置
     */
    private int start;
    //特定场景时需要使用
    private String param;//查询的约束参数,应用场景：从分类列表中-->指定分类的属性列表其中就带有指定分类的id


    /**
     * 有参构造函数
     *
     * @param count
     * @param pageNum
     */
    public Page(int count, int pageNum) {
        this.count = count;
        this.pageNum = pageNum;

    }

    /*计算页数*/
    public int getTotalPages() {
        int totalPages;
        if (0 == totalRecords % count) {
            totalPages = totalRecords / count;
        } else {
            totalPages = totalRecords / count + 1;
        }

        if (totalPages == 0) totalPages = 1;

        return totalPages;
    }

    /**
     * 是否还有前一页
     * 当当前页数为1是表示为第一页，没有前一页了
     *
     * @return
     */
    public boolean isHasPrevious() {
        if (pageNum == 1) return false;
        return true;
    }

    /**
     * 是否还有下一页
     *
     * @return
     */
    public boolean isHasNext() {
        //如果当前页数为总页数,表示是最后一页
        if (pageNum == getTotalPages()) return false;
        return true;

    }

}
