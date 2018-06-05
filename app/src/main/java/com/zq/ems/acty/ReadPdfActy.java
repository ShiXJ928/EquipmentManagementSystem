package com.zq.ems.acty;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

import com.lidong.pdf.PDFView;
import com.lidong.pdf.listener.OnDrawListener;
import com.lidong.pdf.listener.OnLoadCompleteListener;
import com.lidong.pdf.listener.OnPageChangeListener;
import com.zq.ems.R;

/**
 * Created by Administrator on 2018/5/30.
 */

public class ReadPdfActy extends BaseActy implements OnPageChangeListener
        , OnLoadCompleteListener, OnDrawListener {

    private PDFView pdfView;
    private String path;
    private String name;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_read_pdf);

        initView();
    }

    private void initView() {
        intent=getIntent();
        path=intent.getStringExtra("url");
        name=intent.getStringExtra("name");
        pdfView = (PDFView) findViewById(R.id.pdfView);
        displayFromFile1(path, name);
    }

    /**
     * 获取打开网络的pdf文件
     *
     * @param fileUrl
     * @param fileName
     */
    private void displayFromFile1(String fileUrl, String fileName) {
        showProgress();
        pdfView.fileFromLocalStorage(this, this, this, fileUrl, fileName);   //设置pdf文件地址

    }

    /**
     * 翻页回调
     *
     * @param page
     * @param pageCount
     */
    @Override
    public void onPageChanged(int page, int pageCount) {

    }

    /**
     * 加载完成回调
     *
     * @param nbPages 总共的页数
     */
    @Override
    public void loadComplete(int nbPages) {
        hideProgress();
    }

    @Override
    public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
        // Toast.makeText( MainActivity.this ,  "pageWidth= " + pageWidth + "
        // pageHeight= " + pageHeight + " displayedPage="  + displayedPage , Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示对话框
     */
    private void showProgress() {
        dlg.show();
    }

    /**
     * 关闭等待框
     */
    private void hideProgress() {
        dlg.dismiss();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }
}