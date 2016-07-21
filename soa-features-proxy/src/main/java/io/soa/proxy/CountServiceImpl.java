package io.soa.proxy;

/**
 * Created by percy on 7/19/16.
 */
public class CountServiceImpl implements CountService {
    private int count = 0;

    @Override
    public int count() {
        return count ++;
    }
}
