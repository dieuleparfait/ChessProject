interface RestrictionsOnMove {

public static boolean checkAllRules(Board board) {
    return true;
}

    public static boolean OpenCheck(Board board, King king, int player) {
            
        return false;
    }

}
