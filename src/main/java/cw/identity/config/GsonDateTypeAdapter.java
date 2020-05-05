package cw.identity.config;

import java.io.IOException;
import java.util.Date;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class GsonDateTypeAdapter extends TypeAdapter<Date>{

	private static final TypeAdapter<Date> gsonDateTypeAdapter = new GsonDateTypeAdapter();

    public GsonDateTypeAdapter() {
    }

    static TypeAdapter<Date> getGsonDateTypeAdapter() {
        return gsonDateTypeAdapter;
    }

    @Override
    public Date read(final JsonReader in)
            throws IOException {
        // this is where the conversion is performed
    	long date = in.nextLong();
        return new Date(date);
    }

    @Override
    public void write(final JsonWriter out, final Date value)
            throws IOException {
        // write back if necessary or throw UnsupportedOperationException
        out.value(value.getTime());
    }

}
