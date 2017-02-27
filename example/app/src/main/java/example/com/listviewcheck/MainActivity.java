package example.com.listviewcheck;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private int checkId=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listview);
        List<String> list = new ArrayList<>();
        for (int i=0;i<5;i++){
            list.add("名字"+i);

        }
        MyAdapter adapter=new MyAdapter(list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position==checkId){
            listView.setItemChecked(position,false);
            checkId=-1;
        }else {
            checkId=position;
        }
    }

    class MyAdapter extends BaseAdapter{
        private  List<String> list;
        public MyAdapter(List<String> list){
            this.list=list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_item,null);
            TextView textView= (TextView) convertView.findViewById(R.id.item_text);
            textView.setText("item"+list.get(position));
            return convertView;
        }
    }


}
