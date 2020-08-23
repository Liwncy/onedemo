/**
 * 常用js方法封装处理
 * @author liwncy
 * @date 2020-03-23
 */

/**
 * 生成uuid
 */
export function getUuid() {
	var s = [];
	var hexDigits = "0123456789abcdef";
	for (var i = 0; i < 36; i++) {
		s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
	}
	s[14] = "4"; // bits 12-15 of the time_hi_and_version field to 0010
	s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1); // bits 6-7 of the clock_seq_hi_and_reserved to 01
	// s[8] = s[13] = s[18] = s[23] = "-";

	var uuid = s.join("");
	return uuid;
}

// List变成树级结构
export function generateTreeList(list){
	var treeList = [];
	list.forEach((option,index)=>{
		option.children = this.generateTreeList(this.getChildren(option.id,list));
		treeList.push(option);
	})
	return treeList;
}

// 根据父节点获取孩子
export function getChildren(pid,list){
	var children = [];
	list.forEach((option,index)=>{
		if(option.pid == pid){
			children.push(option);
		}
	})
	return children;
}
