.class public towersOfHanoi
.super java/lang/Object

.method public static towersOfHanoi(ICCC)V
    .limit locals 16
    .limit stack 50
;       T4 := 1
    ldc 1
    istore 4
;       T5 := T0 I== T4
    iload 0
    iload 4
    isub
    ifeq L_0
    ldc 0
    goto L_1
L_0:
    ldc 1
L_1:
    istore 5
;       T6 := Z! T5
    iload 5
    ifne L_2
    iconst_1
    goto L_3
L_2:
    iconst_0
L_3:
    istore 6
;       IF T6 GOTO L0
    iload 6
    ifne L0
;       T7 := "Move disk 1 from rod "
    ldc "Move disk 1 from rod "
    astore 7
;       PRINTU T7
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 7
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       PRINTC T1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/print(C)V
;       T8 := " to rod "
    ldc " to rod "
    astore 8
;       PRINTU T8
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 8
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       PRINTLNC T2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 2
    invokevirtual java/io/PrintStream/println(C)V
;       GOTO L1
    goto L1
;       L0:
L0:
;       T9 := 1
    ldc 1
    istore 9
;       T10 := T0 I- T9
    iload 0
    iload 9
    isub
    istore 10
;       CALL towersOfHanoi(T10T1T3T2)
    iload 10
    iload 1
    iload 3
    iload 2
    invokestatic towersOfHanoi/towersOfHanoi(ICCC)V
;       T11 := "Move disk "
    ldc "Move disk "
    astore 11
;       PRINTU T11
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 11
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       PRINTI T0
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 0
    invokevirtual java/io/PrintStream/print(I)V
;       T12 := " from rod "
    ldc " from rod "
    astore 12
;       PRINTU T12
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 12
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       PRINTC T1
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 1
    invokevirtual java/io/PrintStream/print(C)V
;       T13 := " to rod "
    ldc " to rod "
    astore 13
;       PRINTU T13
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 13
    invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V
;       PRINTLNC T2
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 2
    invokevirtual java/io/PrintStream/println(C)V
;       T14 := 1
    ldc 1
    istore 14
;       T15 := T0 I- T14
    iload 0
    iload 14
    isub
    istore 15
;       CALL towersOfHanoi(T15T3T2T1)
    iload 15
    iload 3
    iload 2
    iload 1
    invokestatic towersOfHanoi/towersOfHanoi(ICCC)V
;       L1:
L1:
    return
.end method


.method public static __main()V
    .limit locals 5
    .limit stack 50
;       T1 := 4
    ldc 4
    istore 1
;       T0 := T1
    iload 1
    istore 0
;       T2 := 'A'
    ldc 65
    istore 2
;       T3 := 'C'
    ldc 67
    istore 3
;       T4 := 'B'
    ldc 66
    istore 4
;       CALL towersOfHanoi(T0T2T3T4)
    iload 0
    iload 2
    iload 3
    iload 4
    invokestatic towersOfHanoi/towersOfHanoi(ICCC)V
    return
.end method


;--------------------------------------------;
;                                            ;
; Boilerplate                                ;
;                                            ;
;--------------------------------------------;
.method public static main([Ljava/lang/String;)V
    ; set limits used by this method
    .limit locals 1
    .limit stack 4
    invokestatic towersOfHanoi/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method