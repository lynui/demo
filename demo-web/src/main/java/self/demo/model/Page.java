/**
 * 
 */
package self.demo.model;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * @author liufei45
 * 分页条件
 */
public class Page extends BaseModel{

/**
* 
*/
private static final long serialVersionUID = 746357068179329133L;
/**
 * 开始结果下标, 范围: [0, 1000], 默认值: 0
 */
private int startNo;
/**
 * 每次查询返回的结果数, 范围: [0, 50], 默认值: 10
 */
private int size;

public int getStartNo() {
	return startNo;
}
public void setStartNo(int startNo) {
	this.startNo = startNo;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
@NotEmpty(message = "test2 Message name must not be blank!")
private String test2;

public String getTest2() {
	return test2;
}

public void setTest2(String test2) {
	this.test2 = test2;
}

}
