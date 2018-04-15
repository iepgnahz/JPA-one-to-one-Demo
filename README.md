# spring data jpa实现数据表的一对一关系
- 一对一的实现方式有三种：
  - 单向关联
  
    - Book表知道BookDetail的信息，但是BookDetail端不知道任何关于Book的信息
    - 实现也就是简单的在Book表中加上@OneToOne注解（外键）即可
  - 双向关联
    - 如demo实现
    - 注意经常会出现的错误：递归引用
  - 主键关联（很少用）
