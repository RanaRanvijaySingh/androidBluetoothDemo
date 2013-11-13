androidBluetoothDemo
====================
This application shows you how to use bluetooth of the device . The function is there to enable and disable the bluetooth and to make the device discoverable .
<br/>The steps involved in this process is as follows : 
<br/>
<br/>Step 1: Add permission to the uses in android mainfest  file .
<br/>Step 2: Create the layout of buttons to start and stop the bluetooth .
<br/>Step 3: Create the class to use enable the bluetooth functions.
<br/><br/>
_________________________________________________________________________________________________________________________________________________________

Step 1: Add permission to the uses in android mainfest  file .

    <uses-permission android:name="android.permission.BLUETOOTH" />
    <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />

____________________________________________________________________________________________________________________________________________________________
Step 2: Create the layout of buttons to start and stop the bluetooth .

    <Button
        android:id="@+id/buttonStart"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/start" />

    <Button
        android:id="@+id/buttonDiscoverable"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/search" />

    <Button
        android:id="@+id/buttonStop"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/stop" />

</LinearLayout>
____________________________________________________________________________________________________________________________________________________________

Step 3: Create the class to use enable the bluetooth functions.

	private static final int ENABLE_BLUETOOTH = 0;
	private static final int DISCOVERABLE_BLUETOOTH = 0;
	private final BluetoothAdapter mAdapter = BluetoothAdapter
			.getDefaultAdapter();

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



