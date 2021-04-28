package Default.sms;

import android.Manifest;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class csv extends AppCompatActivity {

    private final String INBOX = "content://sms/inbox";
    private final String SENT = "content://sms/sent";
    public String csvpath;
    private StringBuilder dataset;
    private String firstRow = "";
    private List<String> headers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.csv);
        dataset = new StringBuilder();

    }
}
