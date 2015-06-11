package io.github.UltimateBrowserProject.Browser;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import io.github.UltimateBrowserProject.R;
import io.github.UltimateBrowserProject.Unit.BrowserUnit;

public class UltimateBrowserProjectDownloadListener implements DownloadListener {
    private Context context;

    public UltimateBrowserProjectDownloadListener(Context context) {
        super();
        this.context = context;
    }

    @Override
    public void onDownloadStart(final String url, String userAgent, final String contentDisposition, final String mimeType, long contentLength) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);

        builder.setTitle(R.string.dialog_title_download);
        builder.setMessage(URLUtil.guessFileName(url, contentDisposition, mimeType));

        builder.setPositiveButton(R.string.dialog_button_positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                BrowserUnit.download(context, url, contentDisposition, mimeType);
            }
        });

        builder.setNegativeButton(R.string.dialog_button_negative, null);
        builder.create().show();
    }
}
