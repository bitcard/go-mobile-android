package red.lilu.app.golang;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.PermissionChecker;

import hi.Hi;

public class MainActivity extends AppCompatActivity {

  private static final String T = MainActivity.class.getName();

  private void file() {
    Hi.hiFile("小红");
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    if (requestCode == 1 && grantResults.length == 0) {
      file();
    } else {
      Toast.makeText(this, "没有允许权限!", Toast.LENGTH_LONG)
          .show();
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView text = findViewById(R.id.text);
    text.setText(
        Hi.hiText("小明")
    );

    if (PermissionChecker.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PermissionChecker.PERMISSION_DENIED) {
      Log.d(T, "申请权限");
      requestPermissions(
          new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
          1
      );
    } else {
      Log.d(T, "已有权限");
      file();
    }
  }
}
