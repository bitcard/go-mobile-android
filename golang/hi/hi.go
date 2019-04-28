package hi

import (
	"fmt"
	"io/ioutil"
	"log"
	"strings"
)

//简单方法
func HiText(name string) string {
	fmt.Println("你好", name)

	return strings.Join([]string{"你好", name}, ":")
}

//在外部存储中生成"你好.txt"文件
func HiFile(name string) {
	log.Println("生成文件")

	bytes := []byte(HiText(name))
	err := ioutil.WriteFile("/sdcard/你好.txt", bytes, 0644)
	if err != nil {
		log.Println(err)
	}
}
