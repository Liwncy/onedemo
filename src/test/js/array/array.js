/*
    js操作数组
 */

//var x = [...new Set(years)]//es6数组去重
/**
 * 数组去重
 */
export function deduplication() {
    const allArr = [{id: 1, name: "s"}, {id: 2, name: "ds"}, {id: 3, name: "gg"}];

    // const finalArr = allArr.map(x => {
    //     return x.id
    // });
    console.log(finalArr);
    // 最终结果
    // finalArr = [1,2,3];
}
/**
 * arr.map()
 * 提取数组中所有项的id字段
 */
export function t_map() {
    const allArr = [{id: 1, name: "s"}, {id: 2, name: "ds"}, {id: 3, name: "gg"}];

    const finalArr = allArr.map(x => {
        return x.id
    });
    console.log(finalArr);
    // 最终结果
    // finalArr = [1,2,3];
}
/**
 * arr.filler()
 * 根据id移除数组中指定项
 */
export function t_filler() {
    const arr = [1, 2];
    const allArr = [{id: 1, name: "s"}, {id: 2, name: "ds"}, {id: 3, name: "gg"}];
    const finalArr = allArr.filter((item) => !arr.includes(item.id));
    console.log(finalArr);
    // finalArr = [{id:3,name:"gg"}];
}
/**
 * arr.sort()
 * 根据id排序
 */
export function t_sort() {
    const allArr = [{id: "a", name: "s"}, {id: "c", name: "ds"}, {id: "b", name: "gg"}];
    const finalArr = allArr.sort((a,b)=>a.id.localeCompare(b.id));
    console.log(finalArr);
}

//find
/**
 */
export function test(arr) {

}
