package com.liwncy.oneexamples.javacexp.reptile;

import java.io.BufferedReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import lombok.Data;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


import org.jsoup.Jsoup;

/**
 * 获取github.com的个人仓库目录信息
 */
public class GithubCom {
    static String GITHUBURL = "https://github.com";

    public static void main(String[] args) throws IOException {
        System.out.println("开始");
        String githubName = "Liwncy";
        String repoName = "cloudnotes";
        GithubCom githubCom = new GithubCom();
        String urlpath = GITHUBURL + "/" + githubName + "/" + repoName;

        String html = githubCom.getHtml(urlpath);
        Repo repo = githubCom.getRepoInfo(repoName, html);
        System.out.println("结束");
    }

    /**
     * 获取网站源码
     *
     * @param urlpath
     * @return
     * @throws IOException
     */
    public String getHtml(String urlpath) throws IOException {
        StringBuffer buffer = new StringBuffer();
        URL url = new URL(urlpath);
        URLConnection conn = url.openConnection();

        InputStream in = conn.getInputStream();
        //字节流-》字符流 InputStreamReader
        InputStreamReader reader = new InputStreamReader(in, "utf-8");
        //按行读
        BufferedReader breader = new BufferedReader(reader);
        //读
        String line = "";
        while ((line = breader.readLine()) != null) {
            buffer.append(line);
        }
        return buffer + "";
    }

    /**
     * 获取仓库信息
     *
     * @param rname
     * @param html
     * @return
     * @throws IOException
     */
    public Repo getRepoInfo(String rname, String html) throws IOException {
        Repo repo = new Repo();
        repo.setId("0");
        repo.setName(rname);
//        repo.setChildren(getData(html));
        getData2(html,"##");
        //转成json格式
        List<Object> rlist = new ArrayList<>();
        rlist.add(repo);
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(rlist));
//        String json = JSONObject.toJSONString(repo);
        String json = jsonArray.toString();
        System.out.println(json);
        return repo;
    }

    /**
     * 获取目录数据
     *
     * @param html
     * @return
     * @throws IOException
     */
    public List<Repo> getData(String html) throws IOException {
        List<Repo> list = new ArrayList<>();
        Document document = Jsoup.parse(html);
        // 获取到文件位置
        Elements as = document.getElementsByClass("js-navigation-open link-gray-dark");
        //System.out.println(as);
        for (int i = 0; i < as.size(); i++) {
            Repo repo = new Repo();
            repo.setId(as.get(i).attr("ID"));
            repo.setName(as.get(i).text());
            repo.setUrl(GITHUBURL + as.get(i).attr("href"));
            if (!repo.getUrl().substring(repo.getUrl().lastIndexOf("/") + 1).contains(".")) {
                System.out.println(repo.getUrl());
                String html2 = getHtml(repo.getUrl());
                repo.setChildren(getData(html2));
                repo.setIsFile("0");
            }else {
                repo.setIsFile("1");
                repo.setFastUrl("https://cdn.jsdelivr.net/gh"+as.get(i).attr("href").replace("/blob/master",""));
            }
            list.add(repo);
        }
        return list;
    }
    /**
     * 获取目录数据markdown
     *
     * @param html
     * @return
     * @throws IOException
     */
    public List<Repo> getData2(String html,String jinghao) throws IOException {
        List<Repo> list = new ArrayList<>();
        Document document = Jsoup.parse(html);
        // 获取到文件位置
        Elements as = document.getElementsByClass("js-navigation-open link-gray-dark");
        //System.out.println(as);
        jinghao += "#";
        for (int i = 0; i < as.size(); i++) {
            Repo repo = new Repo();
            repo.setId(as.get(i).attr("ID"));
            repo.setName(as.get(i).text());
            repo.setUrl(GITHUBURL + as.get(i).attr("href"));
            System.out.println(jinghao+"["+repo.getName().replace(".md","")+"]"+"(#"+as.get(i).attr("href").replace("/Liwncy/onenotes/blob/master","").replace(".md","")+")");
            if (!repo.getUrl().substring(repo.getUrl().lastIndexOf("/") + 1).contains(".")) {
//                System.out.println(repo.getUrl());
                String html2 = getHtml(repo.getUrl());
                repo.setChildren(getData2(html2,jinghao));
                repo.setIsFile("0");
            }else {
                repo.setIsFile("1");
                repo.setFastUrl("https://cdn.jsdelivr.net/gh"+as.get(i).attr("href").replace("/blob/master",""));
            }
            list.add(repo);
        }
        return list;
    }
    /**
     * 仓库类
     */
    @Data
    public static class Repo {
        String id;
        String pid;
        String name;
        String url;
        String fastUrl;
        String isFile;
        List<Repo> children;
    }
}

