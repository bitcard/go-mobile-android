package hi

import (
	"fmt"
	"strings"
)

func Hi(name string) string {
	fmt.Println("你好", name)

	return strings.Join([]string{"你好", name}, ":")
}
