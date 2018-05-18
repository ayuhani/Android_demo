package com.ayuhani.demo.download;

/**
 * Created by wang on 2018/5/18.
 */

public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}
