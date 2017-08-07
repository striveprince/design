package com.wmt.design.audio;

import android.media.MediaRecorder;
import android.os.Environment;
import android.text.TextUtils;

import java.io.File;
import java.util.Locale;

/**
 * Created by apple on 2017/7/8.
 */

public class AudioRecordCallback implements Speech {
    private MediaRecorder recorder;
    private File file;
    private String path;
    private int tip;
    private RecordListener result;

    public AudioRecordCallback(String path, RecordListener result) {
        this.result = result;
        this.path = path;
    }

    @Override
    public Exception startListener() {
        try {
            String outputPath = result.startFile(path(),System.currentTimeMillis());
            if (TextUtils.isEmpty(outputPath)) throw new Exception("please set output path");
            file = new File(outputPath);
            if (file.exists())
                throw new Exception("the file already exist file:" + file.getAbsolutePath());
            if (!file.createNewFile())
                return new Exception("create file failed");
            recorder = new MediaRecorder();
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            recorder.setOutputFile(outputPath);
            recorder.prepare();
            recorder.start();
        } catch (Exception e) {
            recorder.release();
            recorder = null;
            return e;
        }
        return null;
    }

    @Override
    public void stopListener(boolean contains) {
        if (recorder != null) {
            recorder.stop();
            recorder.release();
            recorder = null;
        }
        if (result != null) result.onResult(file, tip);
        if (!contains && file != null && file.exists() && file.delete())
            tipListener(deleteSuccess);
    }

    @Override
    public void tipListener(@Status int tipStatus) {
        tip = tipStatus;
    }


    public void setResult(RecordListener result) {
        this.result = result;
    }

    public interface RecordListener {
        void onResult(File file, int tipStatus);
        String startFile(String path, long time);
    }

    public String path() {
        return String.format(Locale.getDefault(), "%1s%1c%2s%2c"
                , Environment.getExternalStorageDirectory()
                , File.separatorChar
                , path
                , File.separatorChar
        );
    }
}
