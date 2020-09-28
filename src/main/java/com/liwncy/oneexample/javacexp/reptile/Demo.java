package com.liwncy.oneexample.javacexp.reptile;

import java.io.BufferedReader;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


import org.jsoup.Jsoup;

/**
 * Demo
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        System.out.println("开始");
        Demo d=new Demo();
        String str=d.getHtml();

        //System.out.println(str);
//      d.write(str);
        d.readHtml(str);

        System.out.println("结束");

    }
    public String getHtml() throws IOException {
        StringBuffer buffer = new StringBuffer();
//      String urlpath="https://sou.zhaopin.com/?jl=801&kw=java&kt=3";
        String urlpath="http://www.dyhjw.com/dyhjw/etf.html";
        URL url = new URL(urlpath);
        URLConnection conn = url.openConnection();

        InputStream in =conn.getInputStream();
        //字节流-》字符流 InputStreamReader
        InputStreamReader reader = new InputStreamReader(in,"utf-8");
        //按行读
        BufferedReader breader = new BufferedReader(reader);
        //读
        String line = "";
        while((line= breader.readLine())!=null)
        {
            buffer.append(line);
        }
        return buffer+"";
    }
    public List<Object[]> readHtml(String html){
        //1. 使用Jsoup解析html -> Document对象
        Document document = Jsoup.parse(html);

        //2. 从Document中找到id=newlist_list_content_table的element
        //  Element div = document.getElementById("newlist_list_content_table");

        //3. 在id=newlist_list_content_table下找到所有class=newslist的elements
//          Elements tables =document.getElementsByClass("sx_table");
//          直接获取整个table的内容
//          System.out.println("tables="+tables);
        Elements trs=document.select("table").select("tr");
        List<Object[]> list=new ArrayList<>();
        File file =new File("d://黄金.txt");
        FileWriter fWriter= null;
        if(!file.exists()) {
            try {
                file.createNewFile();
                fWriter= new FileWriter(file);
                fWriter.append("日期（北京）\t净持仓量（盎司）\t净持仓量（吨）\t总价值（美元）\t总价值（美元）\t影响（金银）\t\n");
                for (int i = 1; i < trs.size(); i++) {
                    Elements tds=trs.get(i).select("td");
                    Object[]obj={tds.get(0).text(),Double.parseDouble(tds.get(1).text()),Double.parseDouble(tds.get(2).text()),
                            Double.parseDouble(tds.get(3).text()),Double.parseDouble(tds.get(4).text()),tds.get(5).text()};
                    list.add(obj);
                    for (int j = 0; j < tds.size(); j++) {
                        String txt=tds.get(j).text();
                        //fWriter.write(txt+"\t");
                        fWriter.append(txt+"\t\n");
                        fWriter.flush();
                        System.out.print(txt+"\t");
                        System.out.println("");
                    }
                }
            }catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
                try {
                    fWriter.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

}

