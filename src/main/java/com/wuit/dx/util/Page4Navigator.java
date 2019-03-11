package com.wuit.dx.util;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author dx
 * @since 2019/3/11 11:30
 */
public class Page4Navigator<T> {
    Page<T> pageFromJpa;
    int navigatePages;
    private int totalPages;
    private long totalElements;
    private List<T> content;
    private int number;
    private int numberOfElements;
    private int size;
    private boolean first;
    private boolean last;
    private boolean hasContent;
    private boolean hasNext;
    private boolean hasPrevious;
    int[] navigateNums;

    public Page<T> getPageFromJpa() {
        return pageFromJpa;
    }

    public void setPageFromJpa(Page<T> pageFromJpa) {
        this.pageFromJpa = pageFromJpa;
    }

    public int getNavigatePages() {
        return navigatePages;
    }

    public void setNavigatePages(int navigatePages) {
        this.navigatePages = navigatePages;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public boolean isHasContent() {
        return hasContent;
    }

    public void setHasContent(boolean hasContent) {
        this.hasContent = hasContent;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

    public int[] getNavigateNums() {
        return navigateNums;
    }

    public void setNavigateNums(int[] navigateNums) {
        this.navigateNums = navigateNums;
    }

    public Page4Navigator() {
    }

    public Page4Navigator(Page<T> pageFromJpa, int navigatePages) {
        this.pageFromJpa = pageFromJpa;
        this.navigatePages = navigatePages;
        this.totalPages = pageFromJpa.getTotalPages();
        this.totalElements = pageFromJpa.getTotalElements();
        this.content = pageFromJpa.getContent();
        this.number = pageFromJpa.getNumber();
        this.numberOfElements = pageFromJpa.getNumberOfElements();
        this.size = pageFromJpa.getSize();
        this.first = pageFromJpa.isFirst();
        this.last = pageFromJpa.isLast();
        this.hasContent = pageFromJpa.hasContent();
        this.hasNext = pageFromJpa.hasNext();
        this.hasPrevious = pageFromJpa.hasPrevious();
        calNavigateNums();
    }

    private void calNavigateNums() {
        int navigatepageNums[];
        int totalPages = getTotalPages();
        int nums = getNumber();
        if (totalPages < navigatePages) {
            navigatepageNums = new int[totalPages];
            for (int i = 0; i < totalPages; i++) {
                navigatepageNums[i] = i + 1;
            }
        } else {
            navigatepageNums = new int[navigatePages];
            int startNum = nums - navigatePages / 2;
            int endNum = nums + navigatePages / 2;
            if (startNum < 1) {
                startNum = 1;
                for (int i = 0; i < navigatePages; i++) {
                    navigatepageNums[i] = startNum++;
                }
            } else if (endNum > totalPages) {
                endNum = totalPages;
                for (int i = navigatePages - 1; i >= 0; i--) {
                    navigatepageNums[i] = endNum--;
                }
            }else{
                for(int i=0;i<navigatePages;i++){
                    navigatepageNums[i]=startNum++;
                }
            }
        }
        this.navigateNums= navigatepageNums;
    }
}
