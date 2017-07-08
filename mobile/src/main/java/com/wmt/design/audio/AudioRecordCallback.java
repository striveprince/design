package com.wmt.design.audio;

import android.media.MediaRecorder;
import android.text.TextUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by apple on 2017/7/8.
 */

public class AudioRecordCallback implements Speech {
    private String outputPath = "";
    private MediaRecorder recorder;
    private File file;

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public Exception startListener() {
//        String outputPath = String.format(Locale.getDefault(), "%1s%1c%2s%2c%3s"
//                  , Environment.getExternalStorageDirectory()
//                  , File.separatorChar
//                  , path
//                  , File.separatorChar
//                  , fileName
//        );
        try {
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

    private int tip;
    private RecordResult result;

    public void setResult(RecordResult result) {
        this.result = result;
    }

    public interface RecordResult {
        void onResult(File file, int tipStatus);
    }
}
