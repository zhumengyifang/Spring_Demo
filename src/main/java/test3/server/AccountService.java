package test3.server;

public interface AccountService {
    /**
     * 转账
     *
     * @param outer
     * @param inner
     * @param money
     */
    public void transfer(String outer, String inner, Integer money);
}
