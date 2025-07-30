package com.bitwormhole.guilink.geometries;

public final class RectUtils {

    private RectUtils() {
    }

    /*****
     * 在 base 的基础上,对方框的各个边向外扩展;
     * 
     * @param base   基础的方框;
     * @param top    上边外扩的距离;
     * @param left   左边外扩的距离;
     * @param right  右边外扩的距离;
     * @param bottom 底边外扩的距离;
     * 
     * @return 返回扩展后的方框
     */

    public static Rect inflate(Rect base, float top, float left, float right, float bottom) {
        Rect res = new Rect(base);
        res.x -= left;
        res.y -= top;
        res.width += (left + right);
        res.height += (top + bottom);
        return res;
    }

    /*****
     * 在 base 的基础上,对方框的各个边向内收缩;
     * 
     * @param base   基础的方框;
     * @param top    上边收缩的距离;
     * @param left   左边收缩的距离;
     * @param right  右边收缩的距离;
     * @param bottom 底边收缩的距离;
     * 
     * @return 返回收缩后的方框
     */

    public static Rect deflate(Rect base, float top, float left, float right, float bottom) {
        Rect res = new Rect(base);
        res.x += left;
        res.y += top;
        res.width -= (left + right);
        res.height -= (top + bottom);
        return res;
    }
}
