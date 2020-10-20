
package ConsCommand;

import ConsCommand.Commands.Command;

public class ConsoleRun {//вызывающий команды(invoker)
    Command add;
    Command del;
    Command list;

    public ConsoleRun(Command add, Command del, Command list) {
        this.add = add;
        this.del = del;
        this.list = list;
    }

    public void addProduct() {
        add.execute();
    }

    public void delProduct() {
        del.execute();
    }

    public void listProduct() {list.execute();}
}
