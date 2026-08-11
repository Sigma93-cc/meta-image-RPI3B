SUMMARY = "my-image recipe"
DESCRIPTION = "Recipe created by A.Sigov"
LICENSE = "MIT"

require recipes-core/images/core-image-minimal.bb

IMAGE_CLASSES += "extrausers"
IMAGE_BOOT_FILES:append = " waveshare35b-v2.dtbo;overlays/waveshare35b-v2.dtbo"

IMAGE_INSTALL:append = " \
    kernel-module-ads7846 \
    qtbase \
    qtbase-plugins \
    boost \
    systemanalyzer \
    qtfbsettings \
    swupdate \
    swupdate-www \
    swupdate-hwrevision \
    libubootenv-bin \
    u-boot \   
    udevrules \
    psplash-sigmastudio \
"

IMAGE_FEATURES:append = " \
    ssh-server-openssh \
    splash \
"

# EXTRA_USERS_PARAMS = "\
#     usermod -p '\$6\$i3OWmbAF6TdHU7Fo\$RtnkUHpXXmACXw0wRUUae1Pz9uS5oYBIe5Wlf/d1ied2Jv9tlKcooQ3oXeOp5Apxs2yMwqpfkt4dfvkoHAk5d1' root; \
# " 

IMAGE_FSTYPES:append = " wic ext4.gz"
IMAGE_FSTYPES:remove = "ext3"
WKS_FILE = "image.wks"

ROOTFS_POSTPROCESS_COMMAND += "add_custom_fstab;"

add_custom_fstab() {
    cat >> ${IMAGE_ROOTFS}/etc/fstab <<EOF
/dev/mmcblk0p1   /boot   vfat    defaults    0  2
/dev/mmcblk0p4   /data   ext4    defaults    0  2
EOF
}

TOOLCHAIN_HOST_TASK:append = " \
     nativesdk-packagegroup-qt5-toolchain-host \   
"
TOOLCHAIN_TARGET_TASK:append= " \
    qtbase-dev \ 
    qtbase-mkspecs \
    spdlog-dev \
    libubootenv-dev \
    fmt-dev \
"