package dao;

public class BookServiceImpl implements BookService {
    @Override
    public void addBook() {
        System.out.println("第二个测试用例!");
        this.bookDao.addBook();
    }

    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
