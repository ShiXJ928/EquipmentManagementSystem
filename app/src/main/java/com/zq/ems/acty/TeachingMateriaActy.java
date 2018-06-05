package com.zq.ems.acty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tencent.smtt.sdk.TbsVideo;
import com.zq.ems.R;
import com.zq.ems.adapter.TeachingMateriaAdapter;
import com.zq.ems.bean.TeachingMateriaBean;
import com.zq.ems.util.DividerGridItemDecoration;
import com.zq.ems.util.ToastUtil;
import com.zq.ems.util.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/31.
 */

public class TeachingMateriaActy extends BaseActy implements TeachingMateriaAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private List<TeachingMateriaBean> list;
    private TeachingMateriaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_teaching_materia);

        initView();
    }

    private void initView() {
        initTitleBar(R.id.title, R.drawable.back, 0, "教学资料", null, R.color.bg_blue1, R.color.white);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        list = new ArrayList<>();
        list.add(new TeachingMateriaBean(
                "http://112.74.179.218:8070/upload/video/1.mp4",
                "http://112.74.179.218:8070/upload/image/1.png",
                "单警新催泪喷射器",
                "mp4"));
        list.add(new TeachingMateriaBean(
                "http://112.74.179.218:8070/upload/video/2.mp4",
                "http://112.74.179.218:8070/upload/image/2.png",
                "单警新催泪喷射器2",
                "mp4"));
        list.add(new TeachingMateriaBean(
                "http://112.74.179.218:8070/upload/video/3.mp4",
                "http://112.74.179.218:8070/upload/image/3.png",
                "单警新催泪喷射器3",
                "mp4"));
        list.add(new TeachingMateriaBean(
                "http://file.chmsp.com.cn/colligate/file/00100000224821.pdf",
                "",
                "00100000224821.pdf",
                "pdf"));
        list.add(new TeachingMateriaBean(
                "http://112.74.179.218:8072/file/随意.pptx",
                "",
                "随意.pptx",
                "pptx"));
        list.add(new TeachingMateriaBean(
                "http://112.74.179.218:8072/file/随意.docx",
                "",
                "随意.docx",
                "word"));
        list.add(new TeachingMateriaBean(
                "http://112.74.179.218:8072/file/随意.xlsx",
                "",
                "随意.xlsx",
                "excel"));

        adapter = new TeachingMateriaAdapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        adapter.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tb_left:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(int position, TeachingMateriaBean model) {
        switch (model.getType()) {
            case "mp4":
                if (model.getType().equals("mp4")) {
                    if (TbsVideo.canUseTbsPlayer(TeachingMateriaActy.this)) {
                        //直接调用播放接口，传入视频流的url
//                    TbsVideo.openVideo(TeachingMateriaActy.this, "http://v.cctv.com/flash/mp4video6/TMS/2011/01/05/cf752b1c12ce452b3040cab2f90bc265_h264818000nero_aac32-1.mp4");
//                        TbsVideo.openVideo(TeachingMateriaActy.this, "http://112.74.179.218:8070/upload/video/2.mp4");
                        TbsVideo.openVideo(TeachingMateriaActy.this, model.getPath());
                    }
                }
                break;
            case "pdf":
                Intent intent = new Intent(TeachingMateriaActy.this, ReadPdfActy.class);
                intent.putExtra("url", model.getPath());
                intent.putExtra("name", model.getName());
                startActivity(intent);
                break;
            case "word":
                ReadWordActy.show(TeachingMateriaActy.this, model.getPath());
                break;
            case "excel":
                ReadWordActy.show(TeachingMateriaActy.this, model.getPath());
                break;
            case "pptx":
                ReadWordActy.show(TeachingMateriaActy.this, model.getPath());
                break;
            default:
                ToastUtil.show("未找到对应类型");
                break;
        }
    }
}
