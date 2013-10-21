package com.webonise.bluetoothdemo;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Ranvijay This application shows the use of bluetooth that can be
 *         activated and de-activated from an application .
 */
public class MainActivity extends Activity implements OnClickListener {

	private static final int ENABLE_BLUETOOTH = 0;
	private static final int DISCOVERABLE_BLUETOOTH = 0;
	private final BluetoothAdapter mAdapter = BluetoothAdapter
			.getDefaultAdapter();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initializeComponents();
	}

	/**
	 * Function to initialize the buttons and other objects.
	 */
	private void initializeComponents() {
		final Button buttonStart = (Button) findViewById(R.id.buttonStart);
		final Button buttonSearch = (Button) findViewById(R.id.buttonDiscoverable);
		final Button buttonStop = (Button) findViewById(R.id.buttonStop);
		final TextView textViewStatus = (TextView) findViewById(R.id.textViewStatus);
		buttonSearch.setOnClickListener(this);
		buttonStart.setOnClickListener(this);
		buttonStop.setOnClickListener(this);
		if (mAdapter == null) {
			textViewStatus.append("Device not Supported");
		}
	}

	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonStart:
			if (!mAdapter.isEnabled()) {
				Intent enableBtIntent = new Intent(
						BluetoothAdapter.ACTION_REQUEST_ENABLE);
				startActivityForResult(enableBtIntent, ENABLE_BLUETOOTH);
			}
			break;
		case R.id.buttonDiscoverable:
			if (!mAdapter.isDiscovering()) {
				Toast.makeText(getApplicationContext(),
						"Making your Bluetooth Enable", Toast.LENGTH_LONG)
						.show();
				Intent enableBtIntent = new Intent(
						BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
				startActivityForResult(enableBtIntent, DISCOVERABLE_BLUETOOTH);
			}
			break;
		case R.id.buttonStop:
			mAdapter.disable();
			Toast.makeText(getApplicationContext(), "Bluetooth Disabled",
					Toast.LENGTH_LONG).show();

			break;

		default:
			break;
		}

	}
}
