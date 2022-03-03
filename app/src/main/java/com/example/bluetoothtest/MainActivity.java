package com.example.bluetoothtest;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    protected static final String TAG  = "Main Activity";

    private final static int REQUEST_ENABLE_BT = 1;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    private BluetoothAdapter btAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAdapter = BluetoothAdapter.getDefaultAdapter();

        private val previewRequest =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val list = it.data
                // do whatever with the data in the callback
            }
        }
        val intent = Intent(this, PreviewFullscreenActivity::class.java)
        intent.putStringArrayListExtra(AppConstants.PARAMS.IMAGE_URIS, list)
        previewRequest.launch(intent);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.d(TAG, "exit");
            return;
        }
        \
        Log.d(TAG, "Getting Bonded Devices");
        System.out.println(btAdapter.getBondedDevices()); //Returns MAC address of p[aired devices

    }
}