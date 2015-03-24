package tk.bizu.introdialog;

import tk.bizu.introdialog.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;

public class MainActivity extends Activity {
	
	static final int DIALOG_CUSTOM_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showDialog(DIALOG_CUSTOM_ID);
			}
		});  
    }

	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog myDialog = null;
		switch (id) {
		case DIALOG_CUSTOM_ID:
			myDialog = new Dialog(this);
			myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
			myDialog.setContentView(R.layout.custom);
			break;
		}
		Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
	    // Dialog 사이즈 조절 하기
	    LayoutParams params = myDialog.getWindow().getAttributes();
	    params.copyFrom(myDialog.getWindow().getAttributes());
	    params.width = LayoutParams.WRAP_CONTENT;
	    params.height = LayoutParams.WRAP_CONTENT;
	    myDialog.getWindow().setAttributes(params);
		return myDialog;
	}
    
  
}
