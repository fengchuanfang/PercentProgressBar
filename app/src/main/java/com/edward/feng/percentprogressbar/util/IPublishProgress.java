package com.edward.feng.percentprogressbar.util;

/**
 * 功能描述：
 *
 * @author (作者) edward（冯丰枫）
 * @link http://www.jianshu.com/u/f7176d6d53d2
 * 创建时间： 2018/4/17 0017
 */
public interface IPublishProgress<Progress> {
    void showProgress(Progress... values);
}