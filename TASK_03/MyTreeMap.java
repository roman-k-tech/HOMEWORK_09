package TASK_03;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MyTreeMap<K, V> extends TreeMap<K, V> {
    @Override
    public String toString() {
        Iterator<Map.Entry<K, V>> i = entrySet().iterator();
        if (!i.hasNext())
            return "{}";

        StringBuilder sb = new StringBuilder();
        DecimalFormat formatter = new DecimalFormat("#00.00");
        for (; ; ) {
            Map.Entry<K, V> e = i.next();
            K key = e.getKey();
            V value = e.getValue();
            sb.append(key == this ? "(this Map)" : key);
            sb.append(" = ");
            if (value.getClass() == Double.class) {
                sb.append(value == this ? "(this Map)" : formatter.format(value) + "%");
            } else {
                sb.append(value == this ? "(this Map)" : value);
            }
            if (!i.hasNext())
                return sb.toString();
            sb.append('\n');
        }
    }
}
