.class public test6
.super java/lang/Object

.method public static __main()V
    .limit locals 17
    .limit stack 50
;       T1 := NEWARRAY F 9
    ldc 9
    newarray float
    astore 1
;       T2 := 34643.234
    ldc 34643.234
    fstore 2
;       T0 := T2
    fload 2
    fstore 0
;       T3 := 0
    ldc 0
    istore 3
;       T4 := 3.1415
    ldc 3.1415
    fstore 4
;       T1[T3] := T4
    aload 1
    iload 3
    fload 4
    fastore
;       T5 := 0
    ldc 0
    istore 5
;       T6 := T1[T5]
    aload 1
    iload 5
    faload
    fstore 6
;       T7 := T0 F== T6
    fload 0
    fload 6
    fcmpl
    ifeq L_0
    ldc 0
    goto L_1
L_0:
    ldc 1
L_1:
    istore 7
;       T8 := Z! T7
    iload 7
    ifne L_2
    iconst_1
    goto L_3
L_2:
    iconst_0
L_3:
    istore 8
;       IF T8 GOTO L0
    iload 8
    ifne L0
;       T9 := "NOICE"
    ldc "NOICE"
    astore 9
;       PRINTLNU T9
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 9
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
;       GOTO L1
    goto L1
;       L0:
L0:
;       T10 := "OOPS"
    ldc "OOPS"
    astore 10
;       PRINTLNU T10
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 10
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
;       L1:
L1:
;       T11 := 0
    ldc 0
    istore 11
;       T12 := T1[T11]
    aload 1
    iload 11
    faload
    fstore 12
;       T13 := 3.1415
    ldc 3.1415
    fstore 13
;       T14 := T12 F== T13
    fload 12
    fload 13
    fcmpl
    ifeq L_4
    ldc 0
    goto L_5
L_4:
    ldc 1
L_5:
    istore 14
;       T15 := Z! T14
    iload 14
    ifne L_6
    iconst_1
    goto L_7
L_6:
    iconst_0
L_7:
    istore 15
;       IF T15 GOTO L2
    iload 15
    ifne L2
;       T16 := "NICE PIE"
    ldc "NICE PIE"
    astore 16
;       PRINTLNU T16
    getstatic java/lang/System/out Ljava/io/PrintStream;
    aload 16
    invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V
;       L2:
L2:
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
    invokestatic test6/__main()V
    return
.end method

; standard initializer
.method public <init>()V
    aload_0
    invokenonvirtual java/lang/Object/<init>()V
    return
.end method