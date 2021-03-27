package com.qdm.file.io;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qiudm
 * @date 2018/10/9 14:43
 * @desc
 */
public class ImageFileRead {

    private static final int EXCEPT_IMAGE_HEIGHT = 200;
    private static final int EXCEPT_IMAGE_WIDTH = 320;
    private static final float EXCEPT_SCALE = 2.5f;

    private static final String WX = "mp.weixin.qq.com";

    private static final String WY = "c.m.163.com";

    @Test
    public void getImageFileInfo()  {

        String url = "https://c.m.163.com/news/a/DTDQ2C5905148AHU.html?spss=newsapp&from=singlemessage";
//        url = "https://zhuanlan.zhihu.com/p/23128101";
//        url = "https://mp.weixin.qq.com/s/YidnoWAMvKjj_YhsOl5U1A";
//        url = "https://mp.weixin.qq.com/s/Ty76-V-U3otck6oao1sIlw";
//        url = "https://mp.weixin.qq.com/s/6AInvcQlMrIxi4X4KdAtDQ";
//        url = "https://c.m.163.com/news/a/DTOTIE5C0001875P.html?spss=newsapp&from=singlemessage&isappinstalled=0";
        url = "https://m.toutiaocdn.com/group/6577978575025078788/?iid=45043218877&app=news_article&timestamp=1538978952&group_id=6577978575025078788";
        url = "https://mp.weixin.qq.com/s/dcqiSM14MQysZNELlltJPQ";
       // url = "http://mp.yishengzhan.cn/art/%2BzZdTnAEbkJIYvRi6OThVg%3D%3D";
       url = "http://mp.yishengzhan.cn/art/YQ8mzbjOKpxRAK2zFRfvYg%3D%3D";
       url  = "https://mp.weixin.qq.com/s/nNYqBPxXos1oxIIUqthH8w";
       url = "http://mp.yishengzhan.cn/art/xkcwoR2FZa7TwvNle78Brg%3D%3D";
//       url = "http://mp.yishengzhan.cn/art/cuVIKXgQls33zYCD6aq0eQ%3D%3D";
        Connection conn = Jsoup.connect(url).timeout(10000);
//        conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//        conn.header("Accept-Encoding", "gzip, deflate, sdch");
//        conn.header("Accept-Language", "zh-CN,zh;q=0.8");
        conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        Document document = null;
        try {
            document = conn.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("document = " + document.toString());
        Elements elements;
        if (url.contains(WY)) {
            elements = document.body().select("figure");
        } else {
            elements = document.body().select("img");
        }

        System.out.println("elements.size = " + elements.size());
        String imgUrl = "";
        List<String> imageUrls = Lists.newArrayList();
        for (Element element : elements) {
//            System.out.println("imgUrl = " + imgUrl);
            if (url.contains(WX)) {
                imgUrl = element.absUrl("data-src");
            } else if(url.contains(WY)) {
                if(element.hasClass("js-img")) {
                    imgUrl = element.absUrl("data-echo");
                }
            } else {
                imgUrl = element.absUrl("src");
            }
            if (StringUtils.isNotBlank(imgUrl)) {
                imageUrls.add(imgUrl);
            }
        }

//        if (imageUrls.size() > 0) {
//            imageUrls.remove(0);
//        }
//        if (imageUrls.size() > 0) {
//            imageUrls.remove(imageUrls.size() - 1);
//        }
//        imageUrls = Lists.newArrayList();
//        imageUrls.add("https://mmbiz.qpic.cn/mmbiz_jpg/xrFYciaHL08CiadJMpz3JXJWGhKnVJa4rgHx4vzN9agNOSQa3uymlPUUVBK9SnyyPbJ6JGfdMG0GZLDBtQMbXmEQ/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1");

        long l1 = System.currentTimeMillis();
        String exceptImageUrl = null;
       // for(int i=0; i< 10000; i++) {
//            System.out.println(new Date().toLocaleString() + "   开始获取期望图 ： " + i);
            exceptImageUrl = getExceptImageUrl(imageUrls);
        //}

        long l2 = System.currentTimeMillis();
        System.out.println("send time=" + (l2 - l1));
        System.out.println("exceptImageUrl = " + exceptImageUrl);
    }

    private String getExceptImageUrl(List<String> imageUrls) {
        if (CollectionUtils.isEmpty(imageUrls)) {
            return null;
        }
        imageUrls = imageUrls.stream().distinct().collect(Collectors.toList());

        for(String imageUrl : imageUrls) {
            System.out.println("imageUrl = " + imageUrl);
            try {
                URL url = new URL(imageUrl);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
                con.setConnectTimeout(2000);
                Integer state = con.getResponseCode();
                if (state == 200 || (state > 300 && state < 400)) {
                    BufferedImage bufferedImage = ImageIO.read(con.getInputStream());
                    int height = bufferedImage.getHeight();
                    int width = bufferedImage.getWidth();
                    if (height > EXCEPT_IMAGE_HEIGHT && width > EXCEPT_IMAGE_WIDTH) {
                        float maxSide = height > width ? height : width;
                        float minSide = height <= width ? height : width;
                        if (maxSide / minSide < EXCEPT_SCALE) {
                            return imageUrl;
                        }
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
//
//        while (imageUrls.size() > 0) {
//            Random random = new Random();
//            int randIndex = random.nextInt(imageUrls.size());
//            String imageUrl = imageUrls.get(randIndex);
//            imageUrls.remove(randIndex);
//            try {
//                URL url = new URL(imageUrl);
//                HttpURLConnection con = (HttpURLConnection) url.openConnection();
//                con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
//                con.setConnectTimeout(2000);
//                Integer state = con.getResponseCode();
//                if (state == 200 || (state > 300 && state < 400)) {
//                    BufferedImage bufferedImage = ImageIO.read(con.getInputStream());
//                    int height = bufferedImage.getHeight();
//                    int width = bufferedImage.getWidth();
//                    if (height > EXCEPT_IMAGE_HEIGHT && width > EXCEPT_IMAGE_WIDTH) {
//                        return imageUrl;
//                    }
//                }
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        return null;
    }


}
