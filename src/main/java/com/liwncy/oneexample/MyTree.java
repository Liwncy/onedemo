package com.liwncy.oneexample;

import com.liwncy.oneexample.javacexp.reptile.GithubCom;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyTree {

  public static void main(String[] args) throws IOException {
    System.out.println("开始");
    List<MyRepo> myRepoList = new ArrayList<>();
    System.out.println("结束");
  }

  /**
   * List变成树级结构
   *
   * @param list
   * @param <T>
   * @return
   */
  public static <T extends Tree> List<Tree> generateTreeList(List<T> list) {
    List<Tree> treeList = new ArrayList<>();
    list.forEach(option -> {
      option.setChildren(generateTreeList(getChildren(option.id, list)));
      treeList.add(option);
    });
    return treeList;
  }

  /**
   * 根据父节点获取孩子
   *
   * @param pid
   * @param list
   * @param <T>
   * @return
   */
  public static <T extends Tree> List<Tree> getChildren(String pid, List<T> list) {
    List<Tree> childList = new ArrayList<>();
    list.forEach(option -> {
      if (pid.equals(option.pid)) {
        childList.add(option);
      }
    });
    return childList;
  }

  /**
   * 树形类
   */
  @Data
  public static class Tree {
    String id;
    String pid;
    List<Tree> children;
  }

  /**
   * 仓库类
   */
  @EqualsAndHashCode(callSuper = true)
  @Data
  public static class MyRepo extends Tree{
    String name;
  }
}
