package com.qdm.io;

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
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author qiudm
 * @date 2018/10/9 14:43
 * @desc
 */
public class ImageFileRead {

    private static final int EXCEPT_IMAGE_HEIGHT = 200;
    private static final int EXCEPT_IMAGE_WIDTH = 320;

    private static final String WX = "mp.weixin.qq.com";

    @Test
    public void getImageFileInfo() throws Exception {

        String url = "https://c.m.163.com/news/a/DTDQ2C5905148AHU.html?spss=newsapp&from=singlemessage";
//        url = "https://zhuanlan.zhihu.com/p/23128101";

        Connection conn = Jsoup.connect(url).timeout(10000);
        conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        conn.header("Accept-Encoding", "gzip, deflate, sdch");
        conn.header("Accept-Language", "zh-CN,zh;q=0.8");
        conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        Document document = conn.get();

        Elements elements = document.body().select("img");
        System.out.println("elements.size = " + elements.size());
        String imgUrl;
        List<String> imageUrls = Lists.newArrayList();
        for (Element element : elements) {
            if (url.contains(WX)) {
                imgUrl = element.absUrl("data-src");
            } else {
                imgUrl = element.absUrl("src");
            }
            if(StringUtils.isNotBlank(imgUrl)) {
                imageUrls.add(imgUrl);
            }
        }

        if (imageUrls.size() > 0) {
            imageUrls.remove(0);
        }
        if (imageUrls.size() > 0) {
            imageUrls.remove(imageUrls.size() - 1);
        }

        long l1 = System.currentTimeMillis();
        String exceptImageUrl = getExceptImageUrl(imageUrls);
        long l2 = System.currentTimeMillis();
        System.out.println("send time=" + (l2 - l1));
        System.out.println("exceptImageUrl = " + exceptImageUrl);
    }

    private String getExceptImageUrl(List<String> imageUrls) {
        if (CollectionUtils.isEmpty(imageUrls)) {
            return null;
        }
        imageUrls = imageUrls.stream().distinct().collect(Collectors.toList());
        while (imageUrls.size() > 0) {
            Random random = new Random();
            int randIndex = random.nextInt(imageUrls.size());
            String imageUrl = imageUrls.get(randIndex);
            imageUrls.remove(randIndex);
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
                        return imageUrl;
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
        return null;
    }


}
