package joinData;

import org.apache.hadoop.io.WritableComparable;
import org.jetbrains.annotations.NotNull;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class TextPair implements WritableComparable {
    public TextPair(String first, String second) {
        this.first = first;
        this.second = second;
    }

    private final String first;
    private final String second;

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    @Override
    public int compareTo(@NotNull TextPair o) {
        int res = first.compareTo(o.getSecond());
        return res == 0 ? second.compareTo(o.getSecond()) : res;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(first);
        dataOutput.writeUTF(second);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {

    }
}
