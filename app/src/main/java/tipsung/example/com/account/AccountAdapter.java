package tipsung.example.com.account;

import android.content.Context;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TipSung on 21/7/2560.
 */

public class AccountAdapter extends ArrayAdapter<Account> {
    private ArrayList accounts;
    Context mContext;
    int resource;


    public AccountAdapter(Context context, int resource, ArrayList<Account> accounts) {
        super(context, resource, accounts);

        this.accounts = accounts;
        this.mContext = context;
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Account account = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null) {
            convertView = mInflater.inflate(resource, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.account_name);
        name.setText(account.getName());

        TextView tel = (TextView) convertView.findViewById(R.id.textView5);
        tel.setText(account.getTel());

        TextView email = (TextView) convertView.findViewById(R.id.textView6);
        email.setText(account.getTel());

        return convertView;
    }
}
