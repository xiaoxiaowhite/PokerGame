APP类
启动类
PokerGame类
牌只要准备一副，所以初始化在静态代码块中运行一遍即可
实现了洗牌发牌功能，将牌按大小花色分配序号1-54，使用HashMap将各个序号映射到相应牌面。
使用collections.shuffle()打乱排序，Treeset<>可以自动排序用来存手牌
